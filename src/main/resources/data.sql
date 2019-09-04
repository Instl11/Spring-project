--delete from Taco_Order_Taco_list;
--delete from Taco_Ingredients;
--delete from Taco;
--delete from Taco_Order;
--delete from Ingredient;

insert into Ingredient (id, name, type) values ('FLTO', 'Flour Tortilla', 'WRAP') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('COTO', 'Corn Tortilla', 'WRAP') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('GRBF', 'Ground Beef', 'PROTEIN') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('CARN', 'Carnitas', 'PROTEIN') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('TMTO', 'Diced Tomatoes', 'VEGGIES') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('LETC', 'Lettuce', 'VEGGIES') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('CHED', 'Cheddar', 'CHEESE') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('JACK', 'Monterrey Jack', 'CHEESE') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('SLSA', 'Salsa', 'SAUCE') ON CONFLICT ( id ) DO NOTHING;
insert into Ingredient (id, name, type) values ('SRCR', 'Sour Cream', 'SAUCE') ON CONFLICT ( id ) DO NOTHING;
