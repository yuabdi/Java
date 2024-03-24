/*
This is your starting point and your testing file. 
Except for task 3 the code should work without modifications once you have everything else implemented.
*/

class OrganizationDriver {
    public static void main(String[] args) {
        //Create some employees with pay
        NonManagerEmployee m1 = new NonManagerEmployee("Bob the undfeated", 300.00, Gender.Male);
        NonManagerEmployee m2 = new NonManagerEmployee("Gorg the smelly", 350.00, Gender.Female);
        NonManagerEmployee m3 = new NonManagerEmployee("Nix the ugly", 50.00, Gender.Male);
        NonManagerEmployee m4 = new NonManagerEmployee("Fredick the killer", 550.00, Gender.Male);
        NonManagerEmployee m5 = new NonManagerEmployee("Sue", 1000.00, Gender.Female);
        NonManagerEmployee m6 = new NonManagerEmployee("Hydra the sneaky", 300.00, Gender.Male);
        NonManagerEmployee m7 = new NonManagerEmployee("Gin the drunk", 300.00, Gender.Male);
        NonManagerEmployee m8 = new NonManagerEmployee("Lin the determined", 300.00, Gender.Female);
        ContractEmployee m9 = new ContractEmployee("Blarg the big", 300.00, Gender.Female, 31, 10, 2020);

        //Generate the organization
        OrganizationImpl monsterCorp = new OrganizationImpl("Ug the Terrible", 300000.00, Gender.UnDisclosed);

        //Create a hierarchy and test
        monsterCorp.addEmployee(m2, "Ug the Terrible");
        monsterCorp.addEmployee(m3, m1.getName());
        monsterCorp.addEmployee(m4, m2.getName());
        monsterCorp.addEmployee(m5, m2.getName());
        monsterCorp.addEmployee(m6, m4.getName());
        monsterCorp.addEmployee(m7, m4.getName());
        monsterCorp.addEmployee(m8, m5.getName());
        monsterCorp.addEmployee(m9, m5.getName());

        //This was part of the sample code provided my the module
        System.out.println(monsterCorp.getSize());

        //Task 1:
        //This you'll have to add. We did it as part of the demo code, but you'll have to modify it to make it work with the new structure
        //Print all the employees along with all their information
        monsterCorp.printEmployees();

        //Task 2:
        //This too is something we did in the demo code, but you'll have to modify it to work here.
        //The syntax on this is a bit challenging, but if you study the getSizeByGender you should be able to figure it out
        //Remember, don't try to guess. Try and understand the existing code and then see how you can change it
        System.out.println(monsterCorp.getSize(m -> m.getAnnualPay() == 300.00));

        //Task 3:
        //Print out a list of just employee names using allEmployees()
        //This is not a hard task. Just make sure you understand what all Employees returns
        for (String name: monsterCorp.allEmployees()){
            System.out.println(name);
        }

        System.out.println();

        //Extra Task
        //Because we aren't implementing a filter, I'm removing this,
        //but I invite you to find a workaround
        System.out.println(monsterCorp.allEmployees(m->!(m.getName().contains("the"))));


        //Extra Task
        //Consider this new structure. Go back and remove any extra code from this implementation and diagram the new structure
        //to confirm you know how it works.

        //Extra Task
        //Implement some new functionality on your own or add back some of the functionality that we had to remove for this new structure.

        System.out.println("\nNew Structure uses the Tree\n");

        Employee CEO = new InternalEmployee("Ug the Terrible", 300000.00, Gender.UnDisclosed);
        TreeNode<Employee> root = new GroupNode<>(CEO);

        root = root.addChild((e)->e.getName().equals(CEO.getName()),new GroupNode<>(m2));
        root = root.addChild((e)->e.getName().equals(m2.getName()),new GroupNode<>(m4));
        root = root.addChild((e)->e.getName().equals(m2.getName()),new GroupNode<>(m5));

        root = root.addChild((e)->e.getName().equals(m4.getName()),new LeafNode<>(m6));
        root = root.addChild((e)->e.getName().equals(m4.getName()),new LeafNode<>(m7));

        root = root.addChild((e)->e.getName().equals(m5.getName()),new LeafNode<>(m8));
        root = root.addChild((e)->e.getName().equals(m5.getName()),new LeafNode<>(m9));

        //convert leaf node m9 to group node, the m9 will supervises the m1
        root = root.addChild((e)->e.getName().equals(m9.getName()),new LeafNode<>(m1));

        //test print
        System.out.println("\nTest print\n");
        root.print();

        //test toList
        System.out.println("\nTest toList\n");
        System.out.println(root.toList());

        //test map
        //map from Tree of employees to Tree of employee names
        System.out.println("\nTest map\n");
        root.map(e -> e.getName()).print();

        //test reduce
        //use reduce to calculate total annual pay
        System.out.println("\nTest reduce\n");
        Employee initialEmp = new InternalEmployee("0", 0, Gender.UnDisclosed);
        Employee result = root.reduce(initialEmp, (x, y) -> new InternalEmployee("", x.getAnnualPay() + y.getAnnualPay(), Gender.UnDisclosed));

        System.out.println("Total annual pay: " + result.getAnnualPay());
    }

}