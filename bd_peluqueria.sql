-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-12-2017 a las 04:08:31
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
(16, '177171679', 'Gabolitro', 42, 'Valdivia', '81728361', 'gabo@gmail.com', '1', '2017-11-02', 0),
(49, '17672234k', 'Lucia Marquez', 23, 'Valdivia', '+569878737', 'lucia@gmail.com', '1', '2017-09-27', 0),
(50, '23456723-5', 'humberto campos', 24, 'Nacimiento', '82912812', 'humbertito@hotmal.com', '1', '2017-09-27', 0),
(61, '16160239-6', 'Valeria Henriquez', 32, 'Valdivia', '', '', '1', '2017-09-29', 0),
(66, '18886384-1', 'camilo alarcón ', 23, 'valdivia', '', '', '0', '2017-10-05', 0),
(67, '188878474', 'Jinjirouxs', 22, 'Niebla', '', '', '1', '2017-10-17', 0),
(68, '188863841', 'camilo', 23, 'valdivia', '', '', '1', '2017-11-02', 0),
(69, '73380448', 'rai', 25, 'v', '33', 'rvega@uach.cl', '0', '2017-11-08', 0);

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
(1, 1, 1, 3, 4, 1, '2017-12-11', 10),
(2, 1231, 123123, 124, 1223, 1234321, '2017-12-11', 0),
(3, 1231, 123123, 124, 1223, 1234321, '2017-12-11', 0),
(4, 1231, 123, 124, 1223, 1234, '2017-12-11', 0),
(5, 10, 10, 10, 5, 5, '2017-12-12', 40),
(6, 1, 2, 3, 4, 5, '2017-12-12', 15),
(7, 0, 0, 0, 0, 0, '2017-12-12', 0),
(8, 0, 0, 0, 0, 1, '2017-12-12', 1),
(9, 123, 1, 12, 3, 4, '2017-12-12', 143);

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
(1, '188863841', 'camilo alarcón', '123123', '123', 777, 1, '2017-10-06'),
(2, '76057063k', 'pancho', '123', '123456', 111, 1, '2017-10-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `id_tratamiento` int(10) NOT NULL,
  `tipo` varchar(200) CHARACTER SET utf8 NOT NULL,
  `precio` int(10) NOT NULL,
  `estado` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`id_tratamiento`, `tipo`, `precio`, `estado`) VALUES
(1, 'Corte mujer', 3000, 1),
(3, 'corte cote', 5000, 1);

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
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `fecha`, `monto_total`, `id_cliente`, `id_tratamiento`, `id_trabajador`) VALUES
(1, '2017-11-29', 20000, 16, 3, 1),
(26, '2017-11-29', 11000, 61, 1, 1),
(27, '2017-11-29', 11000, 50, 3, 1),
(28, '2017-11-29', 11000, 50, 1, 1),
(29, '2017-11-29', 11000, 16, 1, 1),
(30, '2017-11-29', 8000, 1, 1, 1),
(31, '2017-11-29', 8000, 1, 3, 1),
(32, '2017-11-29', 8000, 50, 3, 1),
(33, '2017-11-29', 8000, 50, 1, 1),
(34, '2017-11-29', 8000, 16, 3, 1),
(35, '2017-11-29', 8000, 16, 1, 1),
(36, '2017-11-29', 5000, 66, 3, 1),
(37, '2017-12-11', 8000, 49, 3, 1),
(38, '2017-12-11', 8000, 49, 1, 1),
(39, '2017-12-12', 13000, 49, 1, 1),
(40, '2017-12-12', 13000, 50, 3, 1),
(41, '2017-12-12', 13000, 66, 3, 1),
(42, '2017-12-12', 13000, 61, 3, 1),
(43, '2017-12-12', 13000, 50, 3, 1),
(44, '2017-12-12', 13000, 49, 1, 1),
(45, '2017-12-12', 18000, 49, 3, 1),
(46, '2017-12-12', 18000, 50, 1, 1),
(47, '2017-12-12', 18000, 1, 3, 1),
(48, '2017-12-12', 18000, 50, 3, 1),
(49, '2017-12-12', 13000, 61, 3, 1),
(50, '2017-12-12', 13000, 16, 1, 1),
(51, '2017-12-12', 13000, 49, 3, 1);

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
  MODIFY `id_cliente` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `gastos`
--
ALTER TABLE `gastos`
  MODIFY `id_gastosmes` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `id_trabajador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `id_tratamiento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
