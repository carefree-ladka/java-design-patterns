package behavioral.visitor;

public class MultiplyExpr implements Expr {
    Expr left, right;

    public MultiplyExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
