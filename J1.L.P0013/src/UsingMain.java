public class UsingMain {
    public static void main(String[] args) {
        VehicleList manager = new VehicleList();
        int choice;
        boolean isSaved = true;

        do{
            Validation.printMenu();
            choice = Validation.getInt("Enter choice: ");
            switch (choice) {
                case 1:
                    manager.readFile();
                    break;
                case 2:
                    manager.add();
                    isSaved = false;
                    break;
                case 3:
                    manager.update();
                    isSaved = false;
                    break;
                case 4:
                    manager.delete();
                    isSaved = false;
                    break;
                case 5:
                    manager.search();
                    break;
                case 6:
                    manager.output();
                    break;
                case 7:
                    manager.writeFile();
                    isSaved = false;
                    break;
                default:
                    if(!isSaved){
                        if(Validation.getYesNo("Data changed").equalsIgnoreCase("Yes")){
                            manager.writeFile();
                        }
                    }
                    System.out.println("Bye");
                    return;
            }
        }while (true);
    }
}
