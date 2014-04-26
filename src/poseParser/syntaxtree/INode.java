/* Generated by JTB 1.4.7 */
package poseParser.syntaxtree;

import poseParser.visitor.IRetArguVisitor;
import poseParser.visitor.IRetVisitor;
import poseParser.visitor.IVoidArguVisitor;
import poseParser.visitor.IVoidVisitor;

public interface INode extends java.io.Serializable {

  /** The OS line separator */
  public static final String LS = System.getProperty("line.separator");

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu);

  public <R> R accept(final IRetVisitor<R> vis);

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu);

  public void accept(final IVoidVisitor vis);

}