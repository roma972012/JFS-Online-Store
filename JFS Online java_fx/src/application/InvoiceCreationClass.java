package application;

public class InvoiceCreationClass {
	public static String productName;
    public static String productSize;
    public static String productCode;
    public static String productQty;
    public static String productAmount;
    
    public static String invoiceDetails (){
        String data = "\t\t\t\t\t\t\t     Jeff’s Fishing Shack\n" +
                "\n" +
                "\t\t\t\t\t\t\t\tTax Invoice\n" +
                "\n" +
                "\n" +
                "Jeff’s Fishing Shack\n" +
                "Trading as: Octopus Pty Ltd\n" +
                "Shop 4, Hillarys Boat Harbour\n" +
                "Hillarys, WA, 6025\n" +
                "T:08 9402 2222\n" +
                "E:Sales@JFS.com.au\n" +
                "\n" +
                "\n" +
                "Receipt#: 10412\t\t\t\t\t\t\t\t\t\t\t\t\t\tDate: 04/08/2019\n\n" +
                "Customer: Romesh\n" + 
                "1, Shark Loop\n" +
                "Mindarien\n" +
                "W.A. 6027\n\n" +
                "Customer email: Romesh@gmail.com\n\n" +
                "\tPurchases:\n" +
                "\t\t\t\t No.\tDescription\tCode\tSize\tCost\tQty\tAmount\n" +
                "\t\t\t\t  1\t"+productName+"\t"+productCode+"\t"+productSize+"\t"+productAmount+"\t"+productQty+"\t"+productAmount+"\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal Paid: "+productAmount+"\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t\t\tThank you for your business.\n" +
                "\t\t\t\t\t\t   Jeff’s - where the real fishermen shop.\n";

        return data;
    }
}
