import java.util.*;  

public class ProductComposition{
 static List<String> Ingradients = new ArrayList<String>();  
 static  void add_ingradients(String s)
 {
   String ingredients = new String(s);
   String delim = ","; // TODO: Data can be separated by comma or data may be in table format
   String[] ingredient_list  = ingredients.split(delim);
   for (String ingredient : ingredient_list) {
     Ingradients.add(ingredient);
    }
 }

 static void print_all_ingredients()
 {
   for (String ingredient : Ingradients) {
     System.out.println(ingredient);
   }
 }

 static String find_ingradient_block(String text)
 {
   String text_lower = text.toLowerCase();
   String search_for = "ingredients"; // TODO: collect different names of ingredients , on some products it is composition.
   int start_index = text_lower.indexOf(search_for);
   if(start_index == - 1) {
	System.out.println("Does not contains ingredients in image");
	return null;
   }
   return text_lower.substring(start_index + 11, text_lower.length());
   // TODO: top part of ingredients trim , write logic to trim bottem section which exactly not  ingredient
 }

 static String remove_unwanted_chars(String ingredients)
 {
   String[] unwanted_symbols={"(",")",":"}; //TODO: Keep adding all unwanted chars here
   for(String symbol: unwanted_symbols)
   {
    ingredients =  ingredients.replace(symbol,"");
   }
   return ingredients;
 }

 public static void main(String []args){
  String s = new String("ortadted toothpaste. Store in a cool & dry  place.INGREDIENTS: " +
  "Calcium Carbonate, Sorbitol (70%), DM Water," + 
  "Precipitated Silica, Sodium far Laup Sulphate Powder," +
  "Glycerin, Flavour, Sodium  Carboxymethyl Cellulose, Polyethyl" +
  "Glycol 400, Potassium Nitrate, Titanium Dioxide, Zinc Citrate," +
  "Sodium Benzoate, Tristian Ortho Phosphate, Saccharin Sodium," +
  "Cetylpyridinium Chloride, Clove Oil, Eucalyptus om" +
  "Xanthan Gum");
  String ingredients = find_ingradient_block(s);
  ingredients = remove_unwanted_chars(ingredients);
  add_ingradients(ingredients);
  print_all_ingredients();
 }
}