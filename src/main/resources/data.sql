insert into category (id, name)
values (-1, 'Mujo i Haso');
insert into category (id, name)
values (-2, 'Chuck Norris');
insert into category (id, name)
values (-3, 'Dječiji');

insert into joke (content, category_id)
values ('Mujo i Haso pobjegli iz zatvora. Haso će: - "Pao je snijeg, šta ćemo sada?" - "Ne sekiraj se ti za to, imamo lance!"',
        -1);
insert into joke (content, category_id)
values ('Pitali Muju sta misli o migrantima.
Mujo: - Ja mislim da je to preslo svaku granicu.', -1);
insert into joke (content, category_id)
values ('Chuck Norris je udario kiklopa među oči.', -2);
insert into joke (content, category_id)
values ('Chuck Norris ne pali svjetlo on gasi mrak.', -2);
insert into joke (content, category_id)
values ('Trkaju se dva magarca i jedan kaže: “Ko zadnji – Magarac”.', -3);