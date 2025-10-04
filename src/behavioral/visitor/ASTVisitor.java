package behavioral.visitor;

public class ASTVisitor {
    void main() {

        Expr expr = new MultiplyExpr(
                new AddExpr(new NumberExpr(5), new NumberExpr(3)),
                new NumberExpr(2));

        EvalVisitor evalVisitor = new EvalVisitor();
        PrintVisitor printVisitor = new PrintVisitor();

        int result = expr.accept(evalVisitor);
        String printed = expr.accept(printVisitor);
        IO.println(result); // 16
        IO.println(printed); // ((5 + 3) * 2)
    }
}
