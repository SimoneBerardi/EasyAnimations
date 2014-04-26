/* Generated by JTB 1.4.7 */
package poseParser.visitor;

import poseParser.syntaxtree.*;

public interface IRetVisitor<R> {

  public R visit(final NodeChoice n);

  public R visit(final NodeList n);

  public R visit(final NodeListOptional n);

  public R visit(final NodeOptional n);

  public R visit(final NodeSequence n);

  public R visit(final NodeTCF n);

  public R visit(final NodeToken n);

  public R visit(final Pose n);

  public R visit(final PoseDef n);

  public R visit(final BoneName n);

  public R visit(final BoneDef n);

  public R visit(final Position n);

  public R visit(final PoseName n);

}