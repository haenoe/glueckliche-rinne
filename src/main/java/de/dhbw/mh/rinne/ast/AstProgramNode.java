package de.dhbw.mh.rinne.ast;

import java.util.List;

import de.dhbw.mh.rinne.CodeLocation;
import de.dhbw.mh.rinne.semantic.Scope;

public class AstProgramNode extends AstNode {

    private final Scope scope;

    public AstProgramNode(CodeLocation codeLocation, List<AstStmtNode> statements) {
        super(codeLocation);
        this.scope = new Scope();
        this.children.addAll(statements);
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitProgram(this);
    }

    public Scope getScope() {
        return scope;
    }

}
