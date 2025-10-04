package behavioral.visitor;

public interface Expr {
    <T> T accept(ExprVisitor<T> visitor);
}
