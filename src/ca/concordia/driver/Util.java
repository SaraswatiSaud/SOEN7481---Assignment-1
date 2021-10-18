package ca.concordia.driver;

import java.util.*;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Util {    
    public static MethodDeclaration getMethodDeclaration(Node node) {       
        Node currentParent = node.getParentNode().orElse(null);
        while (!(currentParent instanceof MethodDeclaration) && currentParent != null) {
            currentParent = currentParent.getParentNode().orElse(null);
        }

        MethodDeclaration methodDeclaration = (MethodDeclaration) currentParent;

        if (methodDeclaration == null) {
            return null;
        }

        return methodDeclaration;
    }

    public static String getFunctionName(Node node) {
        MethodDeclaration methodDeclaration = Util.getMethodDeclaration(node);
        if (methodDeclaration == null) {
            return null;
        }
        return Objects.requireNonNull(methodDeclaration).getName().getIdentifier();
    }

    public static String getClassName(Node node) {        
        Node currentParent = node.getParentNode().orElse(null);
        while (!(currentParent instanceof ClassOrInterfaceDeclaration) && currentParent != null) {
            currentParent = currentParent.getParentNode().orElse(null);
        }

        ClassOrInterfaceDeclaration className = (ClassOrInterfaceDeclaration) currentParent;

        if (className == null) {
            return null;
        }
        return Objects.requireNonNull(className).getName().getIdentifier();
    }

    public static int getLineNumber(Node statement) {
        return statement.getRange().isPresent() ? statement.getRange().get().begin.line : 0;
    }
}
