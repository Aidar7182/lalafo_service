package kg.lalfo.lalafoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LalafoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LalafoServiceApplication.class, args);
	}

}
/*
Задание 1
Реализовать REST api, на подобии лалафо.
Сущности:
- товары (автор, название, описание, цена и тип активный,
деактивированный)
- категории товаров(название, описание)
- пользователей(поля на свое усмотрение, без авторизации)
Эндпойты:
- список товаров
- список категорий
- CRUD товаров
- CRUD категорий
- CRUD профиля

1.Нужно получать список товаров по категориям.
2.Сделать фильтрацию товаров по типам (активный, деактивированный).
Так же должен быть поиск по названию товара.
Учесть, что при создании товара нужен пользователь, так как у нас нет авторизации, сойдёт id пользователя в теле запроса.

P.s. Эндпойнты не должны отдавать 500 ошибку)


Задание 2
Сделать фильтрацию по дате, цене (по возрастанию или убыванию)

(Потребуется еще одно поле в сущности товаров)
 */