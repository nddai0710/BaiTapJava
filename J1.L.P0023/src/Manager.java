import java.util.ArrayList;
import java.util.Hashtable;

public class Manager {
    ArrayList<Fruit> listFruit = new ArrayList<>();
    Hashtable<String, ArrayList<Order>> orders = new Hashtable<>();

    public void createFruit(){
        while(true){
            String id = Validation.checkInputString("Nhap ID: ");
            if(checkIdExist(id)){
                System.out.println("ID da ton tai. Hay nhap ID khac.");
                continue;
            }

            String name = Validation.checkInputString("Fruit Name: ");
            double price = Validation.checkInputDouble("Price: ");
            int quantity = Validation.checkInputInt("Quantity: ");
            String origin = Validation.checkInputString("Origin: ");

            listFruit.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Tao thanh cong");

            if(!Validation.checkInputBoolean("Ban co muon tiep tuc(Y/N)? ")){
                return;
            }
        }
    }

    public boolean checkIdExist(String id){
        for(Fruit f : listFruit){
            if (f.getFruitId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public void displayListFruit(){
        System.out.println("List of Fruit:");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s |\n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
        int count = 1;
        for(Fruit f : listFruit){
            if(f.getQuantity() > 0){
                System.out.printf("| %-10d | %-15s | %-15s | %-10.0f$ |\n",
                        count++, f.getFruitName(), f.getOrigin(), f.getPrice());
            }
        }
    }

    public Fruit getFruitByItem(int item){
        int count = 1;
        for(Fruit f : listFruit){
            if(f.getQuantity() > 0){
                if(count == item) return f;
                count++;
            }
        }
        return null;
    }

    public void shopping(){
        if(listFruit.isEmpty()){
            System.out.println("Kho het hang");
            return;
        }

        ArrayList<Order> currentCart = new ArrayList<>();

        while(true){
            displayListFruit();
            System.out.print("Select Item: ");
            int item = Validation.checkInputIntLimit(1, listFruit.size());
            Fruit fruit = getFruitByItem(item);

            if(fruit == null){
                System.out.println("Chon sai ");
                continue;
            }

            System.out.println("You selected: " + fruit.getFruitName());
            int quantity = Validation.checkInputInt("Quantity: ");

            if(quantity > fruit.getQuantity()){
                System.out.println("Kho chi con " + fruit.getQuantity() + " qua");
                continue;
            }

            fruit.setQuantity(fruit.getQuantity() - quantity);

            boolean exist = false;
            for(Order o : currentCart){
                if(o.getFruitName().equalsIgnoreCase(fruit.getFruitName())){
                    o.setQuantity(o.getQuantity() + quantity);
                    exist = true;
                    break;
                }
            }
            if(!exist){
                currentCart.add(new Order(fruit.getFruitName(), quantity, fruit.getPrice()));
            }

            if(Validation.checkInputBoolean("Ban co muon tiep tuc(Y/N)? ")){
                break;
            }
        }

        System.out.println("Product | Quantity | Price | Amount");
        double total = 0;
        for (Order o : currentCart){
            System.out.printf("%-10s%-10d%-10.0f$%-10.0f$\n",
                    o.getFruitName(), o.getQuantity(), o.getPrice(), o.getQuantity() * o.getPrice());
            total += o.getQuantity() * o.getPrice();
        }
        System.out.println("Total : " + total);
        String name = Validation.checkInputString("Nhap ten cua ban: ");

        if(orders.containsKey(name)){
            ArrayList<Order> oldCart = orders.get(name);
            oldCart.addAll(currentCart);
        }else{
            orders.put(name, currentCart);
        }
        System.out.println("Them moi thanh cong");
    }

    public void viewOrder(){
        if(orders.isEmpty()){
            System.out.println("Chua co ai mua hang");
            return;
        }

        for(String name: orders.keySet()){
            System.out.println("Customer: " + name);
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            ArrayList<Order> cart = orders.get(name);
            for(Order o : cart){
                System.out.printf("%10s%10d%10.0f$%10.0f$\n",
                        o.getFruitName(), o.getQuantity(), o.getPrice(), o.getQuantity() * o.getPrice());
                total += o.getQuantity() * o.getPrice();
            }
            System.out.println("Total: " + total);
            System.out.println("--------------------------------");
        }
    }
}
