package behavioral.visitor;

public interface ExprVisitor<T> {
    T visit(NumberExpr num);

    T visit(AddExpr add);

    T visit(MultiplyExpr mul);
}
