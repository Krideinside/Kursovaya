# План автоматизации

## Перечень сценариев покупки тура с открытой страницы http://localhost:8080

### Сценарии покупки с помощью дебетовой карты

##### Позитивные:
#### Сценарий 1. Валидные значения для оплаты APPROVED картой
 - Нажать кнопку "Купить"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать имя и фамилию латинскими буквами, с большой буквы, через пробел, состоящие более чем из 2 букв, например Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* В правом верхнем углу страницы появляется всплывающее уведомление с текстом: "Успешно", также содержащее текст: "Операция одобрена Банком."
   
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/d8a4f5a5-365c-40d3-ab9c-5a9f8dec3f15)

#### Сценарий 2. Валидные значения для оплаты DECLINED картой
 - Нажать кнопку "Купить"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "5555 6666 7777 8888"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать имя и фамилию латинскими буквами, с большой буквы, через пробел, состоящие более чем из 2 букв, например Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Появляется уведомление, что заявка отклонена для данной карты
  
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/7f262457-6818-4ad7-bb8e-bbc6bd02e652)

 #### Сценарий 3. APPROVED карта для покупки в кредит
 - Нажать кнопку "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* В правом верхнем углу страницы появляется всплывающее уведомление с текстом: "Успешно", также содержащее текст: "Операция одобрена Банком."

![image](https://github.com/Krideinside/Kursovaya/assets/129511111/78d1850d-cf63-4782-8193-675097aa31ca)

#### Сценарий 4. DECLINED карта для покупки в кредит
 - Нажать кнопку "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "5555 6666 7777 8888"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Появляется уведомление, что заявка отклонена для данной карты
 
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/446d3bf4-fa8b-43a7-83ef-0700bbac5e26)
  
##### Негативные для обоих вариантов оплаты:
  
#### Сценарий 1. Пустое поле "Номер карты"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" оставить поле "Номер карты" пустым
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Номер карты" подчеркнуто красным и подписано как "Неверный формат"
  
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/bf2e518b-7f2c-4118-af5d-c3b16d4cfa49)
  
#### Сценарий 2. Пустое поле "Месяц"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - Оставить поле "Месяц" пустым
 - В поле "Год" вписать текущий или позднее год
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Месяц" подчеркнуто красным и подписано как "Неверный формат"

![image](https://github.com/Krideinside/Kursovaya/assets/129511111/a7704b11-7b71-4996-b063-d1169c12fe8c)

#### Сценарий 3. Пустое поле "Год"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В поле "Месяц" вписать номер месяца, максимум 12
 - Оставить поле "Год" пустым
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Год" подчеркнуто красным и подписано как "Неверный формат"
  
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/b898f95d-5b01-471a-a37f-1e6cdd733a9d)

#### Сценарий 4. Пустое поле "Владелец"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - Оставить поле "Владелец" пустым
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Владелец" подчеркнуто красным и подписано как "Неверный формат"

![image](https://github.com/Krideinside/Kursovaya/assets/129511111/b6d882ec-540e-4bc1-ab32-832a25f71824)

#### Сценарий 5. Пустое поле "CVC/CVV"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya Vasin
 - Оставить поле "CVC/CVV" пустым
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "CVC" подчеркнуто красным и подписано как "Неверный формат"
  
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/16a16efe-036f-4b73-84a0-70e20eb19c66)

#### Сценарий 6. Меньше 16 цифр в номере карты для обоих вариантов покупок
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "123456"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Номер карты" подчеркнуто красным и подписано как "Неверный формат"
  
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/0c95cf92-b2dd-4277-a452-e83b14849c20)

 #### Сценарий 7. Число больше 12 в поле месяц
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В поле "Месяц" вписать 13
 - В поле "Год" вписать текущий или позднее год
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Месяц" подчеркнуто красным и подписано как "Неверно указан срок действия карты"

![image](https://github.com/Krideinside/Kursovaya/assets/129511111/c34369d1-6bf4-4391-8650-dc1213fae1e2)

 #### Сценарий 8. Прошедший год
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В поле "Месяц" вписать номер месяца, максимум 12
 - В поле "Год" вписать 22
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Год" подчеркнуто красным и подписано как "Истёк срок действия карты"
  
![image](https://github.com/Krideinside/Kursovaya/assets/129511111/de8f7008-e726-4268-b1a3-a34c96fcd91b)

 #### Сценарий 9. Кириллица в поле "Владелец"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Вася Васин
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Владелец" подчеркнуто красным и подписано как "Неверный формат"
  
 #### Сценарий 10. Только 2 буквы в поле "Владелец"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Ва
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Владелец" подчеркнуто красным и подписано как "Неверный формат"
  
 #### Сценарий 11. 1 слово поле "Владелец"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Владелец" подчеркнуто красным и подписано как "Неверный формат"
  
 #### Сценарий 12. Цифры в поле "Владелец"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать 123
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Владелец" подчеркнуто красным и подписано как "Неверный формат"
  
 #### Сценарий 13. Символы в поле "Владелец"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать "."
 - В поле "CVC/CVV" вписать 123
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "Владелец" подчеркнуто красным и подписано как "Неверный формат"
  
 #### Сценарий 14. 000 в поле "CVC/CVV"
 - Нажать кнопку "Купить" или "Купить в кредит"
 - В открывшейся форме "Оплата по карте" в поле "Номер карты" вписать номер "1111 2222 3333 4444"
 - В полях "Месяц" и "Год" вписать дату, позднее текущей
 - В поле "Владелец" вписать Vasya Vasin
 - В поле "CVC/CVV" вписать 000
 - Нажать кнопку "Продолжить"
   - *Ожидаемый результат:* Поле "CVC/CVV" подчеркнуто красным и подписано как "Неверный формат"
  
 # Перечень используемых инструментов с обоснованием выбора

1. Java. Автоматизированное тестирование удобно осуществлять с помощью этого языка
3. Selenide. Для написания удобных для чтения и обслуживания автоматизированных тестов на Java
3. Junit. Для модульного тестирования программного обеспечения на языке Java
4. Faker. Для ускорения заполнения форм
5. Lombok. Для сокращения шаблонного кода
6. Gradle. Для сборки системы автоматического тестирования
7. Docer. Для возможности запуска приложения из контейнера
8. DBeaver. Для возможности взаимодействия с таблицами SQL
9. Allure. Для построения отчётов автотестов с упрощением их анализа
   
# Перечень необходимых разрешений, данных и доступов

1. Доступ к приложению
2. Разрешение на тестирование
3. Разрешение пользоваться тестовой версией, если есть
4. Разрешение тестировать базу данных и API, если требуется

# Перечень и описание возможных рисков при автоматизации

1. Вероятность продления времени выполнения
2. Вероятность отсутствия возможности подключения
3. Вероятность недоступности сайта
4. Вероятность нехватки информации для выполнения работы
5. Вероятность нестабильной работы системы
6. Вероятность сложности с поиском элементов на страницах
7. Вероятность изменения структуры сайта до завершения работы
 
# Перечень необходимых специалистов для автоматизации

1. Специалист, имеющий навыки автоматизированного тестирования, для реализации проекта автотамизации тестирования

# Интервальная оценка с учётом рисков в часах

Приблизительно 48 часов

Дата сдачи проекта: до 04.09.2023








  
