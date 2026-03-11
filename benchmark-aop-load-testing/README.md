# Требуется

1) JDK `21+` (`java --version`)
2) Docker `25.0.0+` (`docker --version`) + Docker-Compose `2.25.0+` (`docker-compose --version`)
3) Bash

# K6

Запуск k6 с выводом графиков в прямом эфире:
```shell
./k6 run -e TARGET_HOST=localhost:8080 --out 'web-dashboard=period=1s' k6-spring-aop.js
```

Графики доступны `http://localhost:5665/`

Запуск k6 с экспортом результатов:
```shell
./k6 run -e TARGET_HOST=localhost:8080 --out 'web-dashboard=period=1s&export=report-page.html&record=kora-report-data-raw.ndjson' k6-spring-aop.js
```

## Сценарии

Сценарии используют 2 CPU и 1152Mb для контейнеров с приложением.

Этапы:

- Прогрев 40 секунд
- Пауза 10 секунд 
- Нагрузка 70 секунд
