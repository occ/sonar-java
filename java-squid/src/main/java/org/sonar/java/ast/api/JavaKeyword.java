/*
 * Sonar Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.ast.api;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.TokenType;
import org.sonar.sslr.grammar.GrammarRuleKey;

public enum JavaKeyword implements TokenType, GrammarRuleKey {

  ASSERT("assert"),
  BREAK("break"),
  CASE("case"),
  CATCH("catch"),
  CLASS("class"),
  CONTINUE("continue"),
  DEFAULT("default"),
  DO("do"),
  ELSE("else"),
  ENUM("enum"),
  EXTENDS("extends"),
  FINALLY("finally"),
  FINAL("final"),
  FOR("for"),
  IF("if"),
  IMPLEMENTS("implements"),
  IMPORT("import"),
  INTERFACE("interface"),
  INSTANCEOF("instanceof"),
  NEW("new"),
  PACKAGE("package"),
  RETURN("return"),
  STATIC("static"),
  SUPER("super"),
  SWITCH("switch"),
  SYNCHRONIZED("synchronized"),
  THIS("this"),
  THROWS("throws"),
  THROW("throw"),
  TRY("try"),
  VOID("void"),
  WHILE("while"),
  TRUE("true"),
  FALSE("false"),
  NULL("null"),
  PUBLIC("public"),
  PROTECTED("protected"),
  PRIVATE("private"),
  ABSTRACT("abstract"),
  NATIVE("native"),
  TRANSIENT("transient"),
  VOLATILE("volatile"),
  STRICTFP("strictfp"),
  BYTE("byte"),
  SHORT("short"),
  CHAR("char"),
  INT("int"),
  LONG("long"),
  FLOAT("float"),
  DOUBLE("double"),
  BOOLEAN("boolean");

  private final String value;

  private JavaKeyword(String value) {
    this.value = value;
  }

  public String getName() {
    return name();
  }

  public String getValue() {
    return value;
  }

  public boolean hasToBeSkippedFromAst(AstNode node) {
    return false;
  }

  public static String[] keywordValues() {
    JavaKeyword[] keywordsEnum = JavaKeyword.values();
    String[] keywords = new String[keywordsEnum.length];
    for (int i = 0; i < keywords.length; i++) {
      keywords[i] = keywordsEnum[i].getValue();
    }
    return keywords;
  }

}
