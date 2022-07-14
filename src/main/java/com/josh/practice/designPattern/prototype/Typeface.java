package com.josh.practice.designPattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Typeface implements Prototype<Typeface> {
    private String fontFamily;
    private String sourceUrl;

    @Override
    public Typeface copy() {
        // 因為兩個成員變數都是 primitive type，所以不需要呼叫任何copy()
        return new Typeface(fontFamily, sourceUrl);
    }
}
