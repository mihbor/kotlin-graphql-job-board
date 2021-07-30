@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package graphql

external interface `T$2` {
    var start: Number
    var end: Number
}

external open class Location(startToken: Token, endToken: Token, source: Source) {
    open var start: Number
    open var end: Number
    open var startToken: Token
    open var endToken: Token
    open var source: Source
    open fun toJSON(): `T$2`
}

external interface `T$3` {
    var kind: Any
    var value: String?
    var line: Number
    var column: Number
}

external open class Token(kind: Any, start: Number, end: Number, line: Number, column: Number, prev: Token?, value: String = definedExternally) {
    open var kind: Any
    open var start: Number
    open var end: Number
    open var line: Number
    open var column: Number
    open var value: String?
    open var prev: Token?
    open var next: Token?
    open fun toJSON(): `T$3`
}

external interface ASTKindToNode {
    var Name: NameNode
    var Document: DocumentNode
    var OperationDefinition: OperationDefinitionNode
    var VariableDefinition: VariableDefinitionNode
    var Variable: VariableNode
    var SelectionSet: SelectionSetNode
    var Field: FieldNode
    var Argument: ArgumentNode
    var FragmentSpread: FragmentSpreadNode
    var InlineFragment: InlineFragmentNode
    var FragmentDefinition: FragmentDefinitionNode
    var IntValue: IntValueNode
    var FloatValue: FloatValueNode
    var StringValue: StringValueNode
    var BooleanValue: BooleanValueNode
    var NullValue: NullValueNode
    var EnumValue: EnumValueNode
    var ListValue: ListValueNode
    var ObjectValue: ObjectValueNode
    var ObjectField: ObjectFieldNode
    var Directive: DirectiveNode
    var NamedType: NamedTypeNode
    var ListType: ListTypeNode
    var NonNullType: NonNullTypeNode
    var SchemaDefinition: SchemaDefinitionNode
    var OperationTypeDefinition: OperationTypeDefinitionNode
    var ScalarTypeDefinition: ScalarTypeDefinitionNode
    var ObjectTypeDefinition: ObjectTypeDefinitionNode
    var FieldDefinition: FieldDefinitionNode
    var InputValueDefinition: InputValueDefinitionNode
    var InterfaceTypeDefinition: InterfaceTypeDefinitionNode
    var UnionTypeDefinition: UnionTypeDefinitionNode
    var EnumTypeDefinition: EnumTypeDefinitionNode
    var EnumValueDefinition: EnumValueDefinitionNode
    var InputObjectTypeDefinition: InputObjectTypeDefinitionNode
    var DirectiveDefinition: DirectiveDefinitionNode
    var SchemaExtension: SchemaExtensionNode
    var ScalarTypeExtension: ScalarTypeExtensionNode
    var ObjectTypeExtension: ObjectTypeExtensionNode
    var InterfaceTypeExtension: InterfaceTypeExtensionNode
    var UnionTypeExtension: UnionTypeExtensionNode
    var EnumTypeExtension: EnumTypeExtensionNode
    var InputObjectTypeExtension: InputObjectTypeExtensionNode
}

external interface NameNode {
    var kind: String /* "Name" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var value: String
}

external interface DocumentNode {
    var kind: String /* "Document" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var definitions: Array<dynamic /* OperationDefinitionNode | FragmentDefinitionNode | SchemaDefinitionNode | ScalarTypeDefinitionNode | ObjectTypeDefinitionNode | InterfaceTypeDefinitionNode | UnionTypeDefinitionNode | EnumTypeDefinitionNode | InputObjectTypeDefinitionNode | DirectiveDefinitionNode | SchemaExtensionNode | ScalarTypeExtensionNode | ObjectTypeExtensionNode | InterfaceTypeExtensionNode | UnionTypeExtensionNode | EnumTypeExtensionNode | InputObjectTypeExtensionNode */>
}

external interface OperationDefinitionNode {
    var kind: String /* "OperationDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var operation: String /* "query" | "mutation" | "subscription" */
    var name: NameNode?
        get() = definedExternally
        set(value) = definedExternally
    var variableDefinitions: Array<VariableDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var selectionSet: SelectionSetNode
}

external interface VariableDefinitionNode {
    var kind: String /* "VariableDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var variable: VariableNode
    var type: dynamic /* NamedTypeNode | ListTypeNode | NonNullTypeNode */
        get() = definedExternally
        set(value) = definedExternally
    var defaultValue: dynamic /* VariableNode? | IntValueNode? | FloatValueNode? | StringValueNode? | BooleanValueNode? | NullValueNode? | EnumValueNode? | ListValueNode? | ObjectValueNode? */
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface VariableNode {
    var kind: String /* "Variable" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
}

external interface SelectionSetNode {
    var kind: String /* "SelectionSet" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var selections: Array<dynamic /* FieldNode | FragmentSpreadNode | InlineFragmentNode */>
}

external interface FieldNode {
    var kind: String /* "Field" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var alias: NameNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var arguments: Array<ArgumentNode>?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var selectionSet: SelectionSetNode?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ArgumentNode {
    var kind: String /* "Argument" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var value: dynamic /* VariableNode | IntValueNode | FloatValueNode | StringValueNode | BooleanValueNode | NullValueNode | EnumValueNode | ListValueNode | ObjectValueNode */
        get() = definedExternally
        set(value) = definedExternally
}

external interface FragmentSpreadNode {
    var kind: String /* "FragmentSpread" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InlineFragmentNode {
    var kind: String /* "InlineFragment" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var typeCondition: NamedTypeNode?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var selectionSet: SelectionSetNode
}

external interface FragmentDefinitionNode {
    var kind: String /* "FragmentDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var variableDefinitions: Array<VariableDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
    var typeCondition: NamedTypeNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var selectionSet: SelectionSetNode
}

external interface IntValueNode {
    var kind: String /* "IntValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var value: String
}

external interface FloatValueNode {
    var kind: String /* "FloatValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var value: String
}

external interface StringValueNode {
    var kind: String /* "StringValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var value: String
    var block: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface BooleanValueNode {
    var kind: String /* "BooleanValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var value: Boolean
}

external interface NullValueNode {
    var kind: String /* "NullValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EnumValueNode {
    var kind: String /* "EnumValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var value: String
}

external interface ListValueNode {
    var kind: String /* "ListValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var values: Array<dynamic /* VariableNode | IntValueNode | FloatValueNode | StringValueNode | BooleanValueNode | NullValueNode | EnumValueNode | ListValueNode | ObjectValueNode */>
}

external interface ObjectValueNode {
    var kind: String /* "ObjectValue" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<ObjectFieldNode>
}

external interface ObjectFieldNode {
    var kind: String /* "ObjectField" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var value: dynamic /* VariableNode | IntValueNode | FloatValueNode | StringValueNode | BooleanValueNode | NullValueNode | EnumValueNode | ListValueNode | ObjectValueNode */
        get() = definedExternally
        set(value) = definedExternally
}

external interface DirectiveNode {
    var kind: String /* "Directive" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var arguments: Array<ArgumentNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface NamedTypeNode {
    var kind: String /* "NamedType" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
}

external interface ListTypeNode {
    var kind: String /* "ListType" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var type: dynamic /* NamedTypeNode | ListTypeNode | NonNullTypeNode */
        get() = definedExternally
        set(value) = definedExternally
}

external interface NonNullTypeNode {
    var kind: String /* "NonNullType" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var type: dynamic /* NamedTypeNode | ListTypeNode */
        get() = definedExternally
        set(value) = definedExternally
}

external interface SchemaDefinitionNode {
    var kind: String /* "SchemaDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var operationTypes: Array<OperationTypeDefinitionNode>
}

external interface OperationTypeDefinitionNode {
    var kind: String /* "OperationTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var operation: String /* "query" | "mutation" | "subscription" */
    var type: NamedTypeNode
}

external interface ScalarTypeDefinitionNode {
    var kind: String /* "ScalarTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ObjectTypeDefinitionNode {
    var kind: String /* "ObjectTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var interfaces: Array<NamedTypeNode>?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<FieldDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface FieldDefinitionNode {
    var kind: String /* "FieldDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var arguments: Array<InputValueDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
    var type: dynamic /* NamedTypeNode | ListTypeNode | NonNullTypeNode */
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InputValueDefinitionNode {
    var kind: String /* "InputValueDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var type: dynamic /* NamedTypeNode | ListTypeNode | NonNullTypeNode */
        get() = definedExternally
        set(value) = definedExternally
    var defaultValue: dynamic /* VariableNode? | IntValueNode? | FloatValueNode? | StringValueNode? | BooleanValueNode? | NullValueNode? | EnumValueNode? | ListValueNode? | ObjectValueNode? */
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InterfaceTypeDefinitionNode {
    var kind: String /* "InterfaceTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var interfaces: Array<NamedTypeNode>?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<FieldDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UnionTypeDefinitionNode {
    var kind: String /* "UnionTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var types: Array<NamedTypeNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EnumTypeDefinitionNode {
    var kind: String /* "EnumTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var values: Array<EnumValueDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EnumValueDefinitionNode {
    var kind: String /* "EnumValueDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InputObjectTypeDefinitionNode {
    var kind: String /* "InputObjectTypeDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<InputValueDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DirectiveDefinitionNode {
    var kind: String /* "DirectiveDefinition" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var description: StringValueNode?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var arguments: Array<InputValueDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
    var repeatable: Boolean
    var locations: Array<NameNode>
}

external interface SchemaExtensionNode {
    var kind: String /* "SchemaExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var operationTypes: Array<OperationTypeDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ScalarTypeExtensionNode {
    var kind: String /* "ScalarTypeExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ObjectTypeExtensionNode {
    var kind: String /* "ObjectTypeExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var interfaces: Array<NamedTypeNode>?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<FieldDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InterfaceTypeExtensionNode {
    var kind: String /* "InterfaceTypeExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var interfaces: Array<NamedTypeNode>?
        get() = definedExternally
        set(value) = definedExternally
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<FieldDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface UnionTypeExtensionNode {
    var kind: String /* "UnionTypeExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var types: Array<NamedTypeNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface EnumTypeExtensionNode {
    var kind: String /* "EnumTypeExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var values: Array<EnumValueDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface InputObjectTypeExtensionNode {
    var kind: String /* "InputObjectTypeExtension" */
    var loc: Location?
        get() = definedExternally
        set(value) = definedExternally
    var name: NameNode
    var directives: Array<DirectiveNode>?
        get() = definedExternally
        set(value) = definedExternally
    var fields: Array<InputValueDefinitionNode>?
        get() = definedExternally
        set(value) = definedExternally
}