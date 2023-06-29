package com.kumbirai.udemy.functional.section5;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class Computer
{
    private Optional<Soundcard> soundcard;
}
