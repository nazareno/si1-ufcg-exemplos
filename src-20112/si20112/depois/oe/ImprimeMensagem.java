package si20112.depois.oe;

/**
 * This program is an elaborate joke about the strucuture of the Java
 * programming language. Technically you'll have to put all the public
 * interfaces and classes in their own file to get it to compile. The actual
 * code came from a slashdot post, comments were later added by ookabooka.
 * 
 * Originally Copyright 2002 MillionthMonkey.
 * 
 * Ridiculously verbose and mostly useless comments (AKA good commenting) added
 * by ookabooka Copyright 2007.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * TODO: Add some try/catches and a plethora of exceptions to further insult
 * Java.
 * 
 * @author ookabooka
 * @version 2.41.54b_2-rc4
 * @see http://ask.slashdot.org/article.pl?sid=07/07/14/2011208
 */

public class ImprimeMensagem {

	/**
	 * The main method, this is what gets run when the program is executed. This
	 * is also all this class has in it.
	 * 
	 * @param args
	 *            completely ignored, here for compliance reasons
	 */
	public static void main(String[] args) {
		AbstractStrategyFactory asf = DefaultFactory.getInstance();
		MessageStrategy strategy = asf.createMessageStrategy();

		MessageBody mb = new MessageBody(strategy);
		mb.setPayload("Hello World!");
		mb.send();
	}
}
