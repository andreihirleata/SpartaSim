package com.sparta.models.TrainingCentres.factory;

import com.sparta.Academy;
import com.sparta.Client;
import com.sparta.models.util.Randomizer;

public class ClientFactory {
public static Client generateClient(){
  return new Client(Randomizer.generateRandomCourse());
}
}