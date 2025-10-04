package behavioral.visitor;

class EvalVisitor implements ExprVisitor<Integer> {
    @Override
    public Integer visit(NumberExpr num) {
        return num.value;
    }

    @Override
    public Integer visit(AddExpr add) {
        return add.left.accept(this) + add.right.accept(this);
    }

    @Override
    public Integer visit(MultiplyExpr mul) {
        return mul.left.accept(this) * mul.right.accept(this);
    }
}

