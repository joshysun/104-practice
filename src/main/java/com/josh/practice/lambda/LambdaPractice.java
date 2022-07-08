package com.josh.practice.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaPractice {
    public static void main(String[] args) {
        LambdaPractice lambdaPractice = new LambdaPractice();
        // Map to List
        lambdaPractice.mapToList();
        // List to Map
        lambdaPractice.listToMap();
        // Sorted List
        lambdaPractice.sortedList();
        // Filter List
        lambdaPractice.filterList();
        // forEach
        lambdaPractice.forEach();
    }

    // Map to List
    public void mapToList() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        List<Map.Entry<Integer, String>> entrySet = map.entrySet().stream().collect(Collectors.toList());
        System.out.println("entrySet: " + entrySet);
        ArrayList<Integer> keys = map.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("keys: " + keys);
        ArrayList<String> values = map.values().stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("values: " + values);
    }

    // List to Map
    public void listToMap() {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(1, "dog"));
        animalList.add(new Animal(2, "cat"));
        animalList.add(new Animal(3, "fish"));

        // id當key，name當value
        Map<Integer, String> listToMap = animalList.stream().collect(Collectors.toMap(animal -> animal.getId(), animal -> animal.getName()));
        System.out.println("listToMap: " + listToMap);

        // 使用id當map的key，再用Animal的bean當value
        Map<Integer, Animal> listToMap2 = animalList.stream().collect(Collectors.toMap(animal -> animal.getId(), Function.identity()));
        System.out.println("listToMap2: " + listToMap2);
    }

    // Sorted List
    public void sortedList() {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(3, "dog"));
        animalList.add(new Animal(1, "cat"));
        animalList.add(new Animal(4, "fish"));
        animalList.add(new Animal(2, "monkey"));

        List<Animal> sortedAnimalList = animalList.stream().sorted(Comparator.comparing(Animal::getId)).collect(Collectors.toList());
        System.out.println("sortedLst: " + sortedAnimalList);
    }

    // Filter List
    public void filterList() {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(3, "dog"));
        animalList.add(new Animal(1, "cat"));
        animalList.add(new Animal(4, "fish"));
        animalList.add(new Animal(2, "monkey"));
        List<Animal> filterList = animalList.stream().filter(animal -> animal.getId() > 2).collect(Collectors.toList());
        System.out.println("filterList: " + filterList);
        List<Animal> filterList2 = animalList.stream().filter(x -> x.getName().startsWith("d")).collect(Collectors.toList());
        System.out.println("filterList2: " + filterList2);
    }

    // forEach
    public void forEach() {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(3, "dog"));
        animalList.add(new Animal(1, "cat"));
        animalList.add(new Animal(4, "fish"));
        animalList.add(new Animal(2, "monkey"));
        animalList.forEach(System.out::println);
    }

    public class Animal{
        private int id;
        private String name;
        public Animal(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {return id;}
        public String getName() {return name;}
        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Animal{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
