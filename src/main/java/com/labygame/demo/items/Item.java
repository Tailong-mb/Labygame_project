package com.labygame.demo.items;

import java.io.Serializable;

public record Item(int bonus, ItemName name, String description) implements Serializable { }