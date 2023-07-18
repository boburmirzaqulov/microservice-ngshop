package io.ngshop.discount;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service{
    private final Repository repository;
    @Override
    public ResponseEntity<DiscountDto> getByProductId(Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<DiscountDto> getDiscount(String slug) {
        String[] split = slug.split("-");
        Long id = Long.parseLong(split[split.length-1]);
        Optional<DiscountEntity> byId = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new NoFoundRecurseException("Not found Recurse")));
        return ResponseEntity.ok((DiscountDto) byId.stream().map(Mapper::toDto).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<String> createDiscount(DiscountCreateDto discountCreateDto) {
        DiscountEntity discount = Mapper.tiEntity(discountCreateDto);
        DiscountEntity save = repository.save(discount);
        return ResponseEntity.ok("saved");
    }

    @Override
    public ResponseEntity<String> deleteDiscount(String slug) {
        String[] split = slug.split("-");
        Long id = Long.parseLong(split[split.length-1]);
        repository.findById(id).orElseThrow(()-> new NoFoundRecurseException("Not found Exception"));
        repository.deleteById(id);
        return ResponseEntity.ok("delete recurse");
    }

    @Override
    public ResponseEntity<DiscountDto> updateDiscount(String slug, DiscountDto discountDto) {
        String[] split = slug.split("-");
        Long id = Long.parseLong(split[split.length-1]);
        repository.findById(id).orElseThrow(()->new NoFoundRecurseException("Not found recurse"));
        discountDto.setId(id);
        return null;
    }


}