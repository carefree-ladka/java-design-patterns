package behavioral.visitor;

class PrintVisitor implements ExprVisitor<String> {
    @Override
    public String visit(NumberExpr num) {
        return String.valueOf(num.value);
    }

    @Override
    public String visit(AddExpr add) {
        return "(" + add.left.accept(this) + " + " + add.right.accept(this) + ")";
    }

    @Override
    public String visit(MultiplyExpr mul) {
        return "(" + mul.left.accept(this) + " * " + mul.right.accept(this) + ")";
    }
}
