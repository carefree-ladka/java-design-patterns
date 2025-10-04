package behavioral.visitor;

public class AddExpr implements Expr {
    Expr left, right;

    public AddExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
