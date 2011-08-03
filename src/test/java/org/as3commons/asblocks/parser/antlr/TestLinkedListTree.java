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

package org.as3commons.asblocks.parser.antlr;

import org.as3commons.asblocks.parser.antlr.LinkedListToken;
import org.as3commons.asblocks.parser.antlr.LinkedListTree;
import org.as3commons.asblocks.parser.antlr.LinkedListTreeAdaptor;
import org.as3commons.asblocks.parser.antlr.as3.AS3Parser;

import junit.framework.TestCase;

public class TestLinkedListTree extends TestCase {
	LinkedListTreeAdaptor adaptor = new LinkedListTreeAdaptor();

	public void testIt() {
		LinkedListToken a = new LinkedListToken(AS3Parser.IDENT, "foo");
		LinkedListTree identA = (LinkedListTree)adaptor.create(a);

		LinkedListToken b = new LinkedListToken(AS3Parser.IDENT, "bar");
		LinkedListTree identB = (LinkedListTree)adaptor.create(b);
		identA.appendToken(new LinkedListToken(AS3Parser.DOT, "."));
		identA.addChildWithTokens(identB);
		
		assertSame(b, a.getNext().getNext());
	}
}