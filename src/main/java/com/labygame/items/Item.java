package com.labygame.items;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
public record Item(int bonus, ItemName name, String description){ }