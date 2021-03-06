////////////////////////////////////////////////////////////////////////////////
// Copyright 2011 Michael Schmalle - Teoti Graphix, LLC
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
// http://www.apache.org/licenses/LICENSE-2.0 
// 
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, 
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and 
// limitations under the License
// 
// Author: Michael Schmalle, Principal Architect
// mschmalle at teotigraphix dot com
////////////////////////////////////////////////////////////////////////////////

package org.as3commons.asblocks.impl;

import java.io.StringWriter;

import org.as3commons.asblocks.ASFactory;
import org.as3commons.asblocks.dom.IASBinaryExpression;
import org.as3commons.asblocks.dom.IASExpression;
import org.as3commons.asblocks.parser.antlr.LinkedListTree;

import junit.framework.TestCase;

public class TokenBoundryTests extends TestCase
{
	private ASFactory fact = new ASFactory();
	private IASBinaryExpression expr;

	public void setUp()
	{
		expr = null;
	}

	public void tearDown()
	{
		if (expr != null)
		{
			StringWriter buff = new StringWriter();
			LinkedListTree ast = ((ASTExpression) expr).getAST();
			new ASTPrinter(buff).print(ast);
			LinkedListTree parsed = AS3FragmentParser
					.parseExpression(buff.toString());
			CodeMirror.assertASTMatch(ast, parsed);
		}
	}

	// TODO: expression list

	//
	//TODO:	public void testAssignment() {
	//		expr = (IASBinaryExpression)fact.newExpression("a = b = c");
	//		ASExpression left = fact.newExpression("foo");
	//		expr.setLeftExpression(left);
	//	}

	// TODO: conditional expression

	public void testLogicalOr()
	{
		expr = (IASBinaryExpression) fact.newExpression("a || b || c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testLogicalAnd()
	{
		expr = (IASBinaryExpression) fact.newExpression("a && b && c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testBitOr()
	{
		expr = (IASBinaryExpression) fact.newExpression("a | b | c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testXor()
	{
		expr = (IASBinaryExpression) fact.newExpression("a ^ b ^ c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testBitAnd()
	{
		expr = (IASBinaryExpression) fact.newExpression("a & b & c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testEquality()
	{
		expr = (IASBinaryExpression) fact.newExpression("a == b == c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testRelational()
	{
		// not strictly possible (I wonder if the grammar should forbid?)
		expr = (IASBinaryExpression) fact.newExpression("a < b < c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testShift()
	{
		expr = (IASBinaryExpression) fact.newExpression("a << b << c");
		IASExpression left = fact.newExpression("foo");
		expr.setLeftExpression(left);
	}

	public void testAdditive()
	{
		expr = (IASBinaryExpression) fact.newExpression("1 + 2 + 2");
		IASExpression left = fact.newIntegerLiteral(1);
		expr.setLeftExpression(left);
	}

	public void testMultiplicative()
	{
		expr = (IASBinaryExpression) fact.newExpression("1 * 2 * 2");
		IASExpression left = fact.newIntegerLiteral(1);
		expr.setLeftExpression(left);
	}
}