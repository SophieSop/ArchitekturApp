%isEmpty(TextView) :-
%isEmpty == "true"
isEmpty(true).
isEmpty(false).

neighbour(TextView1, TextView2) :-
isEmpty(TextView1), isEmpty(TextView2),
TextView1 \== TextView2.

horizontal_grid(a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5,d1,d2,d3,d4,d5,e1,e2,e3,e4,e5) :-
neighbour(a1,a2), neighbour(a1,b1),
neighbour(a2,a3), neighbour(a2,b2),
neighbour(a3,a4), neighbour(a3,b3),
neighbour(a4,a5), neighbour(a4,b4),
neighbour(a5,b5),
neighbour(b1,b2), neighbour(b1,c1),
neighbour(b2,b3), neighbour(b2,c2),
neighbour(b3,b4), neighbour(b3,c3),
neighbour(b4,b5), neighbour(b4,c4),
neighbour(b5,c5),
neighbour(c1,c2), neighbour(c1,d1),
neighbour(c2,c3), neighbour(c2,d2),
neighbour(c3,c4), neighbour(c3,d3),
neighbour(c4,c5), neighbour(c4,d4),
neighbour(c5,d5),
neighbour(d1,d2), neighbour(d1,e1),
neighbour(d2,d3), neighbour(d2,e2),
neighbour(d3,d4), neighbour(d3,e3),
neighbour(d4,d5), neighbour(d4,e4),
neighbour(d5,e5),
neighbour(e1,e2),
neighbour(e2,e3),
neighbour(e3,e4),
neighbour(e4,e5).


vertical_grid(f1,f2,f3,f4,f5,g1,g2,g3,g4,g5,h1,h2,h3,h4,h5,i1,i2,i3,i4,i5,j1,j2,j3,j4,j5).
horizontal_row(1,a1,a2,a3,a4,a5).
horizontal_row(2,a2,b2,c2,d2,e2).
horizontal_row(3,a3,b3,c3,d3,e3).
horizontal_row(4,a4,b4,c4,d4,e4).
horizontal_row(5,a5,b5,c5,d5,e5).

%Beispiel mit Katze
allergic(Person,Tier):-
    allergy(Person,cats),
    cats(Tier).
%Wenn Tier eine Katze ist und Person allergisch gegen Katzen ist, dann ist Person allergisch gegen Tier.
separation(Person,Tier):-
    allergic(Person,Tier).
move(X,Y):-
moveIntoGarden(Y);
moveIntoHouse(X).
%Wenn Person gegen Tier allergisch ist dann sollen sie getrennt werden.
moveIntoGarden(Tier):-
separation(Person,Tier).
%Wenn Person und Tier getrennt werden sollen, dann soll Tier im Garten wohnen.
moveIntoHouse(Person):-
separation(Person,Tier).
%Wenn Person und Tier getrennt werden sollen, dann soll Person in eine andere Wohnung ziehen.

%Bauwagen / trailer
trailer(X) :-
emptySpace(X), userGroupFlexiblity(X), ( newBuilding(X); extension(X) ), networking(X), densityLow(X) , villageStructure(X).

networking(X) :-
networkingRegional(X), networkingHigh(X).

%Neubau / newBuilding
newBuilding(X) :-
 emptySpace(X); developmentArea(X) .

% Bestand / stock ; Anbau / annex
useStock(X) :-
compression(X), buildingUsable(X), ( annex(X) ; extension(X) ), notMaxDensity(X).

% max. Dichte nicht erreicht / not maximal density
%notMaxDensity(X) :-
%floor < 8.

buildingUsable(X) :-
verticalExtension(X), notMaxDensitiy(X).

% Gemeinschaftsraum / commonRoom (collectiveStructures --> Besitz/Eigentum)
commonRoom(X) :-
(networkingOwnUserGroup(X);networkingRegional(X);networkingInternational(X)), collectiveStructures(X), networkingHigh(X).

% Ruheraum/individuelle Plätze
privateRoom(X) :-
networkingLow(X), not(commonRoom).

% Orte der Vernetzung/Sammelplätze/Technikturm / spots
spots(X) :-
networkingHigh(X), (processOrientated(X); fixedPointsForParentFunction(X)).

% Interferenz Nutzungmuster / interference usage pattern --> noch nicht richtig
interferenceUsagePatternSeparationLiving(X) :-
interferenceUsagePatternSeparationOfFunctions(X), interferenceUsagePatternLiving(X).

interferenceUsagePatternSeparationBusiness(X) :-
interferenceUsagePatternSeparationOfFunctions(X), interferenceUsagePatternBusiness(X).

interferenceUsagePatternSeparationBusiness(X) :-
interferenceUsagePatternSeparationOfFunctions(X), interferenceUsagePatternBusiness(X).

% Barrieren / Barriers
barriersVisualCover(X) :-
barriersNoVisualInsights(X), privacyHigh(X).

barriersKinkingPassage(X) :-
barriersNoVisualInsights(X), barriersInhibitionThreshold(X).

% Infrastruktur / Infrastructure

infrastructureStreets(X) :-
infrastructureTrafficConcept(X).

infrastructurePaths(X) :-
infrastructureOnlyPedestrians(X).

infrastructureBicyclePath(X) :-
infrastructureNoCars(X), infrastructureSaveResources(X).

infrastructureWoodsAndSees(X) :-
infrastructureRecreation(X), infrastructureLivingCloseToNature(X).

infrastructureBroadStreet(X) :-
infrastructureCars(X), trafficDensityHigh(X).

infrastructureAverageRoad(X) :-
trafficDensityMedium(X).

infrastructureSmallRoads(X) :-
trafficDensityLow(X), infrastructureNoCars(X).

infrastructureWaterSupplyLocation(X) :-
infrastructureCentralSupplyLocation(X).

infrastructurePowerSupplyLocation(X) :-
infrastructureCentralSupplyLocation(X).

infrastructureTrafficNetwork(X) :-
infrastructureOptimizedTrafficNetwork(X).

% Universelle Raumlehre /-konzept Universal space concept
universalSpaceConceptNoAnimalFarming(X) :-
veganism(X).

universalSpaceConceptFreeSchool(X) :-
autarky(X).

universalSpaceConceptSeminarCenter(X) :-
autarky(X).

universalSpaceConceptFarmShop(X) :-
autarky(X), workOnSite(X), holisticWayOfLife(X), insideOutsideRelation(X).

universalSpaceConceptWindmill(X) :-
renewableEnergies(X), sustainableLife(X).

universalSpaceConceptPhotovoltaicModule(X) :-
renewableEnergies(X), sustainableLife(X).

universalSpaceConceptCourtyard(X) :-
ventilation(X), buildingsWithCenter(X).

universalSpaceConceptStaircase(X) :-
lightAxis(X), verticalAxis(X).

universalSpaceConceptSpine(X) :-
horizontalAxis(X).

% Materialien / Materials

% Schilflehm
reedMud(X) :-
radiationShielding(X), privateRoom(X), naturalMaterials(X).

bambooWood(X) :-
basicConstruction(X), easilyAccessible(X), naturalMaterials(X) selfBuild(X), individualRoomSolutions(X), flexibleMaterials(X),
variabilityInDensity(X), verticalStructures(X), horizontalStructures(X).

clothFoil(X) :-
selfBuild(X),  recyclableMaterials(X), multifuntionalMaterials(X), changeableElement(X), flexibleMaterials(X).

brickConcrete(X) :-
durable(X), solidMaterials(X).

% Wenn Person Vater von Z ist und Z  Vater von Tier ist, dann ist Person Großvater von  Tier
    grossvater(Person,Tier) :- vater(Person,Z), vater(Z,Tier).
% Adam ist der Vater von Tobias
    vater(adam,tobias).
% Tobias ist der Vater von Frank
    vater(tobias,frank).