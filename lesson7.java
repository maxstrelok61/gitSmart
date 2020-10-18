public class Main {
	public static void main(String[] args) {
		Eat eat1 = new Eat("Амлет", (byte)20, (byte)1);
		Eat eat2 = new Eat("Вискас", (byte)50, (byte)1);
		Eat eat3 = new Eat("Мясо сырое", (byte)55, (byte)1);
		Eat eat4 = new Eat("Рыба жаренная", (byte)70, (byte)1);
		Eat eat5 = new Eat("Молоко", (byte)100, (byte)2);
		
		Eat[] eatArr = {eat1, eat2, eat3, eat4, eat5};
		
		Cat cat1 = new Cat("Черныш", 10);
		Cat cat2 = new Cat("Валя", 50);
		
		Cat[] catArr = {cat1, cat2};
		
		Plate plate1 = new Plate((byte) 100);
		Plate plate2 = new Plate((byte) 100);
		
		Plate[] plateArr = {plate1, plate2};
		
		plateArr[0].addEat(eatArr[1]);
		plateArr[1].addEat(eatArr[2]);
		
		
		for(int i = 0; i < catArr.length; i++){
			for(int y = 0; y < plateArr.length; y++)
		  	catArr[i].feeding(plateArr[y]);
		  	catArr[i].printSatiety();
		}
		
		plateArr[0].thisEat.addEat(20);
		
	
	}
}
class Eat{
 String name;
 byte colEat; //Количество еды
 byte satiety; //Сытость еды 
 // Множитель для количества
 
 Eat(String name, byte colEat, byte satiety){
 	this.name = name;
 	this.colEat = colEat;
 	this.satiety = satiety;
 }
 int getAllSatietyEat(){
 	return this.colEat * this.satiety;
 }
 void addEat(int col){
 	this.colEat += col;
 	System.out.println("Еда " + this.name + " пополнилась на " + col + " и теперь составляет " + this.colEat);
 }
}

class Plate{
	Eat thisEat;
	byte volome;
	
	Plate(byte volome){
		this.volome = volome;
	}
	//ложим в тарелку еду
	void addEat(Eat thisEat){
		if (this.volome >= thisEat.colEat) this.thisEat = thisEat;
		else System.out.println("данная еда не помещается в тарелку");
	}
}
class Cat{
	String name;
	int satiety;
	
	
	Cat(String name, int satiety){
		this.name = name;
		this.satiety = satiety;// 0 - сытый 
	}
	//кушаем
	void feeding (Plate plate){
		if(this.satiety <= plate.thisEat.getAllSatietyEat()){
			int tempVal = (int) this.satiety / plate.thisEat.satiety;
			plate.thisEat.colEat -=  tempVal;
			this.satiety = 0;
			System.out.println("Кошка (" + this.name + ") поела " + plate.thisEat.name + " и полностью наелась (осталось " + plate.thisEat.colEat + ")");
		}else System.out.println("Еды (" + plate.thisEat.name + ") на тарелке не достаточно что бы уталить голод кошки " + this.name);
	}
	
	void printSatiety(){
		System.out.println("Сытость кота " + this.name + " = " + this.satiety);
	}
}