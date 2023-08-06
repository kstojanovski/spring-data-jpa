# JPA Knowledge - Syntax

## Cascade
_Source_:
* http://bealdung.com/jpa-cascade_types
* https://www.youtube.com/watch?v=K2Id3WLZWJI

_Note_:
* Using CascadeType.REMOVE removes the assoiciate entity on 1:n relation one by one which leads to executing many SQL commands where only one delete SQL command suffice.

## Orphan removal
On 1:n relation, when the "parent" entity is deleted then with this attribute all "children" entity will also be removed.
