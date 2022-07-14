package com.josh.practice.designPattern.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrototypeTest {
    @Test
    void prototypeTestIfObjectIsDeepCopied() {
        Typeface typeface = new Typeface("OGFontFamily", "OGUrl");
        Font font = new Font(typeface, "OGFontName");
        Font fontCopy = font.copy();

        // change fontFamily value in fontCopy's typeface argument
        fontCopy.getTypeface().setFontFamily("ChangeFontFamily");
        assertThat(font.getTypeface().getFontFamily()).isNotEqualTo(fontCopy.getTypeface().getFontFamily());
    }

}