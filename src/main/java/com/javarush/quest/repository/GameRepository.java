package com.javarush.quest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.entity.Game;
import lombok.Getter;

import java.io.InputStream;

@Getter
public class GameRepository {

    private final Game game;

    public GameRepository() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream is = getClass().getClassLoader()
                    .getResourceAsStream("hr-quest.json");

            if (is == null) {
                throw new RuntimeException("Файл hr-quest.json не найден");
            }

            game = objectMapper.readValue(is, Game.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
