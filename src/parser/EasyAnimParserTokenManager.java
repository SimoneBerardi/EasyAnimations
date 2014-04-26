/* Generated By:JavaCC: Do not edit this line. EasyAnimParserTokenManager.java */
package parser;
import parser.visitor.*;
import java.io.FileInputStream;
import parser.syntaxtree.*;

/** Token Manager. */
public class EasyAnimParserTokenManager implements EasyAnimParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x8ffffdeL) != 0L)
         {
            jjmatchedKind = 32;
            return 6;
         }
         if ((active0 & 0x6000000L) != 0L)
            return 6;
         return -1;
      case 1:
         if ((active0 & 0x8f3cf5eL) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 1;
            return 6;
         }
         if ((active0 & 0xc3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x80L) != 0L)
            return 6;
         return -1;
      case 2:
         if ((active0 & 0xc3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x8f3cf1eL) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 2;
            return 6;
         }
         if ((active0 & 0x40L) != 0L)
            return 6;
         return -1;
      case 3:
         if ((active0 & 0xc3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x210L) != 0L)
            return 6;
         if ((active0 & 0x8f3cd0eL) != 0L)
         {
            if (jjmatchedPos != 3)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 3;
            }
            return 6;
         }
         return -1;
      case 4:
         if ((active0 & 0xc3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x8000110L) != 0L)
            return 6;
         if ((active0 & 0xf3c80eL) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return 6;
         }
         return -1;
      case 5:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0xc3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x8000000L) != 0L)
            return 6;
         if ((active0 & 0xeL) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 5;
            return 6;
         }
         return -1;
      case 6:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0x3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0xeL) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 6;
            return 6;
         }
         return -1;
      case 7:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0x3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0xeL) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 7;
            return 6;
         }
         return -1;
      case 8:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0x3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x2L) != 0L)
            return 6;
         if ((active0 & 0x8L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 8;
            return 6;
         }
         return -1;
      case 9:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0x3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x8L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 9;
            return 6;
         }
         return -1;
      case 10:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0x3000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 0;
            }
            return -1;
         }
         if ((active0 & 0x8L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 10;
            return 6;
         }
         return -1;
      case 11:
         if ((active0 & 0xf3c000L) != 0L)
         {
            if (jjmatchedPos < 4)
            {
               jjmatchedKind = 32;
               jjmatchedPos = 4;
            }
            return -1;
         }
         if ((active0 & 0x8L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 11;
            return 6;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStartNfaWithStates_0(0, 25, 6);
      case 41:
         return jjStartNfaWithStates_0(0, 26, 6);
      case 44:
         return jjStopAtPos(0, 24);
      case 59:
         return jjStopAtPos(0, 5);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x42L);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x4L);
      case 72:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0xaaa000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x210L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x41000L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x8L);
      case 85:
         return jjMoveStringLiteralDfa1_0(0x514000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x8000100L);
      case 123:
         return jjStopAtPos(0, 30);
      case 125:
         return jjStopAtPos(0, 31);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 32:
         return jjMoveStringLiteralDfa2_0(active0, 0xc3000L);
      case 69:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 72:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 79:
         return jjMoveStringLiteralDfa2_0(active0, 0xa28000L);
      case 80:
         return jjMoveStringLiteralDfa2_0(active0, 0x514000L);
      case 100:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x2L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x210L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000100L);
      case 116:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(1, 7, 6);
         break;
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0xcL);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      case 69:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 72:
         return jjMoveStringLiteralDfa3_0(active0, 0xc0000L);
      case 80:
         return jjMoveStringLiteralDfa3_0(active0, 0x514000L);
      case 83:
         return jjMoveStringLiteralDfa3_0(active0, 0x3000L);
      case 87:
         return jjMoveStringLiteralDfa3_0(active0, 0xa28000L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000100L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x8L);
      case 100:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(2, 6, 6);
         break;
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x4L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x210L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa4_0(active0, 0x8L);
      case 68:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 69:
         return jjMoveStringLiteralDfa4_0(active0, 0xf3c000L);
      case 72:
         return jjMoveStringLiteralDfa4_0(active0, 0x3000L);
      case 73:
         return jjMoveStringLiteralDfa4_0(active0, 0xc0000L);
      case 83:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x4L);
      case 101:
         if ((active0 & 0x200L) != 0L)
         {
            jjmatchedKind = 9;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x10L);
      case 109:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000102L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(4, 10);
         break;
      case 79:
         return jjMoveStringLiteralDfa5_0(active0, 0x3000L);
      case 80:
         return jjMoveStringLiteralDfa5_0(active0, 0xc0000L);
      case 82:
         return jjMoveStringLiteralDfa5_0(active0, 0xf3c000L);
      case 84:
         return jjMoveStringLiteralDfa5_0(active0, 0x800L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x2L);
      case 101:
         if ((active0 & 0x100L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 4;
         }
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x8L);
      case 115:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(4, 4, 6);
         break;
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x4L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 32:
         return jjMoveStringLiteralDfa6_0(active0, 0xf3c000L);
      case 58:
         if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(5, 11);
         else if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(5, 18);
         else if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(5, 19);
         break;
      case 85:
         return jjMoveStringLiteralDfa6_0(active0, 0x3000L);
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0xcL);
      case 115:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(5, 27, 6);
         break;
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 76:
         return jjMoveStringLiteralDfa7_0(active0, 0xc33000L);
      case 82:
         return jjMoveStringLiteralDfa7_0(active0, 0x30c000L);
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x2L);
      case 109:
         return jjMoveStringLiteralDfa7_0(active0, 0x8L);
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x4L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 32:
         return jjMoveStringLiteralDfa8_0(active0, 0xf3c000L);
      case 68:
         return jjMoveStringLiteralDfa8_0(active0, 0x3000L);
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0x8L);
      case 110:
         return jjMoveStringLiteralDfa8_0(active0, 0x4L);
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x4L) != 0L)
            return jjStopAtPos(8, 2);
         break;
      case 65:
         return jjMoveStringLiteralDfa9_0(active0, 0x3c000L);
      case 69:
         return jjMoveStringLiteralDfa9_0(active0, 0x3000L);
      case 76:
         return jjMoveStringLiteralDfa9_0(active0, 0xf00000L);
      case 110:
         if ((active0 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(8, 1, 6);
         break;
      case 116:
         return jjMoveStringLiteralDfa9_0(active0, 0x8L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 69:
         return jjMoveStringLiteralDfa10_0(active0, 0xf00000L);
      case 82:
         return jjMoveStringLiteralDfa10_0(active0, 0x3f000L);
      case 105:
         return jjMoveStringLiteralDfa10_0(active0, 0x8L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private int jjMoveStringLiteralDfa10_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(10, 12);
         else if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(10, 13);
         break;
      case 71:
         return jjMoveStringLiteralDfa11_0(active0, 0xf00000L);
      case 77:
         return jjMoveStringLiteralDfa11_0(active0, 0x3c000L);
      case 111:
         return jjMoveStringLiteralDfa11_0(active0, 0x8L);
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
static private int jjMoveStringLiteralDfa11_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(9, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, active0);
      return 11;
   }
   switch(curChar)
   {
      case 58:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(11, 14);
         else if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(11, 15);
         else if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(11, 16);
         else if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(11, 17);
         else if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(11, 20);
         else if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(11, 21);
         else if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(11, 22);
         else if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(11, 23);
         break;
      case 110:
         return jjMoveStringLiteralDfa12_0(active0, 0x8L);
      default :
         break;
   }
   return jjStartNfa_0(10, active0);
}
static private int jjMoveStringLiteralDfa12_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(10, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(11, active0);
      return 12;
   }
   switch(curChar)
   {
      case 115:
         if ((active0 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(12, 3, 6);
         break;
      default :
         break;
   }
   return jjStartNfa_0(11, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0x0L, 0x204130100000000L
};
static final long[] jjbitVec1 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 19;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x83ff438200000000L & l) != 0L)
                  {
                     if (kind > 32)
                        kind = 32;
                     jjCheckNAdd(6);
                  }
                  else if (curChar == 47)
                     jjAddStates(0, 1);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddTwoStates(3, 4);
                  }
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 28)
                        kind = 28;
                     jjCheckNAdd(2);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 28)
                        kind = 28;
                  }
                  break;
               case 1:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 28)
                     kind = 28;
                  jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 28)
                     kind = 28;
                  jjCheckNAdd(2);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddTwoStates(3, 4);
                  break;
               case 4:
                  if (curChar == 46)
                     jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(5);
                  break;
               case 6:
                  if ((0x83ff438200000000L & l) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if (curChar == 47)
                     jjAddStates(0, 1);
                  break;
               case 8:
                  if (curChar == 47)
                     jjCheckNAddStates(2, 4);
                  break;
               case 9:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(2, 4);
                  break;
               case 10:
                  if ((0x2400L & l) != 0L && kind > 37)
                     kind = 37;
                  break;
               case 11:
                  if (curChar == 10 && kind > 37)
                     kind = 37;
                  break;
               case 12:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(14, 15);
                  break;
               case 14:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(14, 15);
                  break;
               case 15:
                  if (curChar == 42)
                     jjAddStates(5, 6);
                  break;
               case 16:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(17, 15);
                  break;
               case 17:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(17, 15);
                  break;
               case 18:
                  if (curChar == 47 && kind > 38)
                     kind = 38;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 6:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  jjCheckNAdd(6);
                  break;
               case 9:
                  jjAddStates(2, 4);
                  break;
               case 14:
                  jjCheckNAddTwoStates(14, 15);
                  break;
               case 16:
               case 17:
                  jjCheckNAddTwoStates(17, 15);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 6:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 32)
                     kind = 32;
                  jjCheckNAdd(6);
                  break;
               case 9:
                  if ((jjbitVec1[i2] & l2) != 0L)
                     jjAddStates(2, 4);
                  break;
               case 14:
                  if ((jjbitVec1[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(14, 15);
                  break;
               case 16:
               case 17:
                  if ((jjbitVec1[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(17, 15);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 19 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   8, 13, 9, 10, 12, 16, 18, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", "\101\156\151\155\141\164\151\157\156", 
"\104\165\162\141\164\151\157\156\72", "\123\165\142\101\156\151\155\141\164\151\157\156\163", 
"\120\157\163\145\163", "\73", "\101\144\144", "\141\164", "\146\162\141\155\145", "\120\157\163\145", 
"\110\105\101\104\72", "\103\110\105\123\124\72", "\122\40\123\110\117\125\114\104\105\122\72", 
"\114\40\123\110\117\125\114\104\105\122\72", "\125\120\120\105\122\40\122\40\101\122\115\72", 
"\114\117\127\105\122\40\122\40\101\122\115\72", "\125\120\120\105\122\40\114\40\101\122\115\72", 
"\114\117\127\105\122\40\114\40\101\122\115\72", "\122\40\110\111\120\72", "\114\40\110\111\120\72", 
"\125\120\120\105\122\40\122\40\114\105\107\72", "\114\117\127\105\122\40\122\40\114\105\107\72", 
"\125\120\120\105\122\40\114\40\114\105\107\72", "\114\117\127\105\122\40\114\40\114\105\107\72", "\54", "\50", "\51", 
"\146\162\141\155\145\163", null, null, "\173", "\175", null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1ffffffffL, 
};
static final long[] jjtoSkip = {
   0x7e00000000L, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[19];
static private final int[] jjstateSet = new int[38];
static protected char curChar;
/** Constructor. */
public EasyAnimParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public EasyAnimParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 19; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
