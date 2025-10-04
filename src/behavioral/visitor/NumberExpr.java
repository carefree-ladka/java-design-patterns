package behavioral.visitor;

public class NumberExpr implements Expr {
    int value;

    public NumberExpr(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
