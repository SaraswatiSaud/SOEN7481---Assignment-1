package ca.concordia.bugFinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ca.concordia.bugPatterns.BugPattern;
import ca.concordia.bugPatterns.DuplicateMessageInCatchBlock;
import ca.concordia.driver.Util;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * This class finds BugPattern 3 from the file.
 * @author Saraswati Saud
 *
 */
public class DuplicateMessageInCatchBlockBugFinder implements BugFinder {    
    public List<BugPattern> check(File projectDir) {
        List<BugPattern> bugPatterns = new ArrayList<>();

        new FileExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(TryStmt n, Object arg) {
                        super.visit(n, arg);

                        ArrayList<String> al = new ArrayList<>();

                        for (CatchClause c : n.getCatchClauses()) {
                            List<Node> childNodes = c.getChildNodes();
                            for (Node nodesInOneCatchBlock : childNodes) {

                                if (nodesInOneCatchBlock instanceof BlockStmt) {

                                    List<Statement> ListStatementOfCatchBlock = ((BlockStmt) nodesInOneCatchBlock).getStatements();

                                    for (Statement statementOfCatchBlock : ListStatementOfCatchBlock) {

                                        List<Node> listNodeOfOneBlockStatementOfEachCatchBlock = statementOfCatchBlock.getChildNodes();

                                        for (Node nodeOfOneBlockStatementOfEachCatchBlock : listNodeOfOneBlockStatementOfEachCatchBlock) {

                                            if (nodeOfOneBlockStatementOfEachCatchBlock instanceof MethodCallExpr) {

                                                MethodCallExpr method = ((MethodCallExpr) nodeOfOneBlockStatementOfEachCatchBlock);
                                                String methodName = method.getNameAsString();

                                                // Flag to know if we should report the method
                                                boolean shouldReportBug = false;

                                                if (methodName.matches("warn|println|info|debug|error")) {
                                                    if (method.getArguments().size() == 0) {
                                                        shouldReportBug = true;
                                                    }

                                                    if (method.getArguments().size() == 1 &&
                                                            method.getArgument(0) instanceof StringLiteralExpr) {
                                                        String args = method.getArgument(0).toString();

                                                        if (!(al.contains(args))) {
                                                            al.add(args);
                                                        } else {
                                                            shouldReportBug = true;
                                                        }
                                                    }
                                                   
                                                    if (shouldReportBug) {
                                                        int lineNumber = Util.getLineNumber(method);
                                                        String functionName = Util.getFunctionName(n);
                                                        bugPatterns.add(new DuplicateMessageInCatchBlock(lineNumber, file, functionName));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        al.clear();
                    }

                }.visit(JavaParser.parse(file), null);
            } catch (IOException e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);

        return bugPatterns;
    }

}
