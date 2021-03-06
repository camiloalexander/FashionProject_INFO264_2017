-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 17-12-2017 a las 09:22:54
-- Versión del servidor: 5.7.20
-- Versión de PHP: 7.0.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_peluqueria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(100) NOT NULL,
  `run` varchar(30) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(150) CHARACTER SET utf8 NOT NULL,
  `edad` int(4) NOT NULL,
  `ciudad` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `telefono` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `correo` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `estado` varchar(5) CHARACTER SET utf8 NOT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `beneficio` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `run`, `nombre`, `edad`, `ciudad`, `telefono`, `correo`, `estado`, `fecha_ingreso`, `beneficio`) VALUES
(1, '000000000', 'Anónimo(a)', 0, 'Valdivia', '', NULL, '1', '2017-11-29', 0),
(2, '178552015', 'Gabriel Galilea', 25, 'Valdivia', '', '', '1', '2017-11-02', 0),
(3, '17672234k', 'Lucia Marquez', 23, 'Valdivia', '', '', '1', '2017-09-27', 0),
(4, '236111415', 'Humberto Campos', 24, 'Valdivia', '', '', '1', '2017-12-16', 0),
(5, '182885746', 'Maria Jose Nuñez', 24, 'Valdivia', '', '', '1', '2017-12-16', 0),
(6, '188863841', 'Camilo Alarcón', 23, 'Valdivia', '', '', '1', '2017-12-16', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

CREATE TABLE `gastos` (
  `id_gastosmes` int(10) NOT NULL,
  `luz` int(10) NOT NULL,
  `agua` int(10) NOT NULL,
  `arriendo` int(10) NOT NULL,
  `internet` int(10) NOT NULL,
  `otros` int(10) NOT NULL,
  `fecha_Gasto` date NOT NULL,
  `total_gasto` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `gastos`
--

INSERT INTO `gastos` (`id_gastosmes`, `luz`, `agua`, `arriendo`, `internet`, `otros`, `fecha_Gasto`, `total_gasto`) VALUES
(1, 1231, 0, 0, 0, 0, '2017-12-16', 1231),
(2, 0, 1231, 0, 3234, 0, '2017-12-16', 4465);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `id_trabajador` int(5) NOT NULL,
  `run` varchar(15) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(150) CHARACTER SET utf8 NOT NULL,
  `telefono` varchar(30) CHARACTER SET utf8 NOT NULL,
  `pass` varchar(150) CHARACTER SET utf8 NOT NULL,
  `privilegios` int(5) NOT NULL,
  `estado` int(5) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`id_trabajador`, `run`, `nombre`, `telefono`, `pass`, `privilegios`, `estado`, `fecha_ingreso`) VALUES
(1, '145100720', 'Ximena Alejandra Nuñez Ruiz', '941418361', 'xnuñez', 777, 1, '2017-12-15'),
(2, '101499235', 'Maria Jesus Norambuena Parra', '993005357', 'mnorambuena', 111, 1, '2017-12-15'),
(3, '188863841', 'otro', '123123', '123', 777, 1, '2017-10-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `id_tratamiento` int(10) NOT NULL,
  `tipo` varchar(200) CHARACTER SET utf8 NOT NULL,
  `precio` int(10) NOT NULL,
  `estado` int(3) NOT NULL,
  `porcentaje` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`id_tratamiento`, `tipo`, `precio`, `estado`, `porcentaje`) VALUES
(1, 'Corte Niño', 3000, 1, 50),
(2, 'Corte Varon', 4000, 1, 50),
(3, 'Corte Mujer', 5000, 1, 50),
(4, 'Tintuta Pelo Corto', 15000, 1, 50),
(5, 'Tintura Pelo Largo', 18000, 1, 50),
(6, 'Alisado Permanente Pelo Corto', 20000, 1, 50),
(7, 'Alisado Permanente Pelo Largo', 30000, 1, 50),
(8, 'Masaje Capilar', 15000, 1, 50),
(9, 'Tratamiento Capilar Botox', 25000, 1, 50),
(10, 'Tratamiento Capilar Shot Keratina', 20000, 1, 50),
(11, 'Visos', 16000, 1, 50),
(12, 'Mechas Pelo Corto', 25000, 1, 50),
(13, 'Mechas Pelo Largo', 30000, 1, 50),
(17, '123', 123, 0, 20),
(18, '1233', 123, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(100) NOT NULL,
  `fecha` date NOT NULL,
  `monto_total` int(50) NOT NULL,
  `id_cliente` int(50) NOT NULL,
  `id_tratamiento` int(50) NOT NULL,
  `id_trabajador` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `gastos`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`id_gastosmes`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`id_trabajador`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`id_tratamiento`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `gastos`
--
ALTER TABLE `gastos`
  MODIFY `id_gastosmes` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `id_trabajador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `id_tratamiento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=174;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
