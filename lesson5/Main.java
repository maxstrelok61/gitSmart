package project1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
	Sotrudnik[] persArray = new Sotrudnik[5];

	persArray[0] = new Sotrudnik("Сосулькин Епифан Афронтьевич",
                              "Управляющий садомазахист",
                                "zzz@sado.ru",
                                "6(666)666-66-66",
                                60666.001,
								new GregorianCalendar (1666, 6, 6));

	persArray[1] = new Sotrudnik("Голлумов Хоббит Кольцович",
								"Пещерный шнырь",
								"golum@NewZealand.gol",
								"Только телепатия",
								-77000.001,
								new GregorianCalendar (145, Calendar.DECEMBER, 7));

	persArray[2] = new Sotrudnik("Пещеркин Альберт Мухович",
								"Простой алкаш",
								"PishiteVse@mail.ru",
								"03 Спросить Вытрезвитель",
								70.001,
								new GregorianCalendar (1985, Calendar.DECEMBER, 17));

	persArray[3] = new Sotrudnik("Баба Яга Кощеева",
								"Знахарка",
								"Бабка@Ёжка.лес",
								"постучать 3 раза по дереву \nплюнуть 2 раза через правое колено",
								70000.001,
								new GregorianCalendar (1, 1, 1));

	persArray[4] = new Sotrudnik("ПРобинзон Крузо",
								"Странник",
								"Robinzone@mail.ru",
								"5555555555",
								600111.001,
								new GregorianCalendar (1719, Calendar.APRIL, 25));

	GregorianCalendar thisDate = new GregorianCalendar();//Настоящая дата

	System.out.println(thisDate.get(Calendar.YEAR));
	for(int i = 0; i < persArray.length; i++){
		if((thisDate.get(Calendar.YEAR) - persArray[i].dateBeth.get(Calendar.YEAR)) >= 40) persArray[i].printInfo();

	}
    }
}
