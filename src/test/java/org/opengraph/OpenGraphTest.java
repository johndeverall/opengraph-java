package org.opengraph;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opengraph.OpenGraph;


public class OpenGraphTest {
  @Test
  public void shouldHandleMissingContentType() throws java.lang.Exception {
    OpenGraph site = new OpenGraph("http://www.bbc.com/future/story/20140428-the-myth-of-tech-revolutions", true);
    Assertions.assertEquals("Why it�s time to ditch the word �revolution� in tech", site.getContent("title"));
    Assertions.assertEquals("624", site.getContent("image:width"));
  }

  @Test
  public void shouldNoOGMarkup() throws java.lang.Exception {
    OpenGraph site = new OpenGraph("http://clang.llvm.org/docs/UsersManual.html", true);
    Assertions.assertNull(site.getContent("title"));
  }
} 