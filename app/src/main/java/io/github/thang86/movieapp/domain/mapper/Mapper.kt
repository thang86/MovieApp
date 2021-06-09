package io.github.thang86.movieapp.domain.mapper

@FunctionalInterface
interface Mapper<in DomainObject, out UIObject> {
    fun mapFrom(item: DomainObject): UIObject
}
