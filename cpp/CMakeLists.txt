cmake_minimum_required(VERSION 3.10)

project(algorithm)

set(CMAKE_CXX_FLAGS -std=c++14)

set(HEADER_FILES
    data_structure/array.hpp)

set(SOURCE_FILES
    main.cpp)

add_executable(algorithm_test ${HEADER_FILES} ${SOURCE_FILES})