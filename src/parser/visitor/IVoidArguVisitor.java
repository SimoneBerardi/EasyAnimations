/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;

public interface IVoidArguVisitor<A> {

  public void visit(final NodeChoice n, final A argu);

  public void visit(final NodeList n, final A argu);

  public void visit(final NodeListOptional n, final A argu);

  public void visit(final NodeOptional n, final A argu);

  public void visit(final NodeSequence n, final A argu);

  public void visit(final NodeTCF n, final A argu);

  public void visit(final NodeToken n, final A argu);

  public void visit(final Animation n, final A argu);

  public void visit(final AnimationDef n, final A argu);

  public void visit(final SubAnimation n, final A argu);

  public void visit(final Pose n, final A argu);

  public void visit(final PoseDef n, final A argu);

  public void visit(final BoneName n, final A argu);

  public void visit(final BoneDef n, final A argu);

  public void visit(final Frame n, final A argu);

  public void visit(final Position n, final A argu);

  public void visit(final AnimationName n, final A argu);

  public void visit(final PoseName n, final A argu);

  public void visit(final Duration n, final A argu);

}
