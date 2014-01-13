--
-- База данных: `somedb`
--
CREATE DATABASE IF NOT EXISTS `somedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `somedb`;

-- --------------------------------------------------------

--
-- Структура таблицы `usertest`
--

CREATE TABLE IF NOT EXISTS `usertest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Структура таблицы `user_address`
--

CREATE TABLE IF NOT EXISTS `user_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

