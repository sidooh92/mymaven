package com.mymaven;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");

        Teammate teammate =  new Teammate();
        teammate.setName("Frodo");
        teammate.setHasRing(false);

        Teammate teammate1 = new Teammate();
        teammate1.setName("Gandalf");
        teammate1.setHasRing(false);

        Teammate teammate2 =  new Teammate();
        teammate2.setName("Aragorn");
        teammate2.setHasRing(false);

        Teammate teammate3 =  new Teammate();
        teammate3.setName("Legolas");
        teammate3.setHasRing(true);

        List<Teammate> teammateList = new ArrayList<>();
        teammateList.add(teammate);
        teammateList.add(teammate1);
        teammateList.add(teammate2);
        teammateList.add(teammate3);

        List<Teammate> collect = teammateList.stream().map(t -> {
            if (t.isHasRing()) {
                t.setName(t.getName() + " has ring");
            } else {
                t.setName(t.getName() + " doesn't have ring");
            }
            return t;
        }).collect(Collectors.toList());

        List<Teammate> listWthRing = collect
                .stream()
                .filter(teamMember -> !teamMember.isHasRing())
                .collect(Collectors.toList());

        //listWthRing.forEach(p -> System.out.println(p));
        listWthRing.forEach(System.out::println);

    }
}
