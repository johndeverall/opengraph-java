package org.opengraphtests;

import org.junit.Test;
import org.opengraph.OpenGraph;

import static org.junit.Assert.*;

public class OpenGraphTest {
  @Test
  public void shouldHandleMissingContentType() throws java.lang.Exception {
    OpenGraph site = new OpenGraph("http://www.bbc.com/future/story/20140428-the-myth-of-tech-revolutions", true);
    assertEquals("Why it’s time to ditch the word ‘revolution’ in tech", site.getContent("title"));
    assertEquals("624", site.getContent("image:width"));
  }

  @Test
  public void shouldNoOGMarkup() throws java.lang.Exception {
    OpenGraph site = new OpenGraph("http://clang.llvm.org/docs/UsersManual.html", true);
    assertNull(site.getContent("title"));
  }
} 