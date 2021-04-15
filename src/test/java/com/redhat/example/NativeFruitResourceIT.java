package com.redhat.example;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeFruitResourceIT extends FruitResourceTest {

    // Execute the same tests but in native mode.
}