#ifndef ARRAY_H
#define ARRAY_H

#include <iostream>

template<typename E>
class Array
{
public:
    Array(unsigned int capacity)
        : data_(new E[capacity])
        , capacity_(capacity)
        , size_(0) 
    {
    }

    Array() : Array(8) 
    {
    }

    virtual ~Array() 
    { 
        delete[] data_; 
    }

    void AddLast(E e)
    {
        if (size_ == capacity_)
            Resize(capacity_ * 2);

        data_[size_] = e;
        size_++;
    }

    E RemoveLast()
    {
        if (0 == size_)
            return 0;

        E e = data_[size_ - 1];
        data_[size_ - 1] = 0;
        size_--;

        if (size_ <= capacity_ / 4 && capacity_ / 2 > 1)
            Resize(capacity_ / 2);

        return e;
    }

    void Set(int index, E e)
    {
        data_[index] = e;
    }

    E get(int index)
    {
        return data_[index];
    }

    unsigned int GetCapacity() const
    {
        return capacity_;
    }

    unsigned int GetSize() const
    {
        return size_;
    }

    void PrintInfo()
    {
        std::cout << "------------------------------------------" << std::endl;
        std::cout << "[";
        for (int i = 0; i < size_; ++i)
        {
            std::cout << data_[i];
            if (i < size_ - 1)
                std::cout << ", ";
        }
        std::cout << "]" << std::endl;
        std::cout << "size = " << size_ << ", capacity = " << capacity_ << std::endl;
    }

    E& operator[](int index)
    {
        return data_[index];
    }

private:
    void Resize(int new_capacity)
    {
        E* tmp = data_;
        data_ = new E[new_capacity];
        for (int i = 0; i < size_; ++i)
            data_[i] = tmp[i];
        
        capacity_ = new_capacity;
    }

    E* data_;
    unsigned int capacity_;
    unsigned int size_;
};

#endif //ARRAY_H