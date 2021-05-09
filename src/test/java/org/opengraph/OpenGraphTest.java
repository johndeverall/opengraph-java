package org.opengraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import org.junit.Test;

public class OpenGraphTest {
  @Test
  public void shouldHandleMissingContentType() throws java.lang.Exception {
    OpenGraph site = new OpenGraph("https://www.bbc.com/future/article/20140428-the-myth-of-tech-revolutions", true);
    assertEquals("Why it’s time to ditch the word ‘revolution’ in tech", site.getContent("title"));
    assertEquals("624", site.getContent("image:width"));
  }

  @Test
  public void shouldNoOGMarkup() throws java.lang.Exception {
    OpenGraph site = new OpenGraph("http://clang.llvm.org/docs/UsersManual.html", true);
    assertNull(site.getContent("title"));
  }
} 